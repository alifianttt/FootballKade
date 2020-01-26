package com.yoga.footballleague.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoga.footballleague.R
import com.yoga.footballleague.adapter.MatchAdapter
import com.yoga.footballleague.adapter.TeamAdapter
import com.yoga.footballleague.behave.invisible
import com.yoga.footballleague.match.MatchIntf
import com.yoga.footballleague.match.MatchPresenter
import com.yoga.footballleague.matchdetail.DetailMatch
import com.yoga.footballleague.model.EventDetail
import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.model.LeagueData
import com.yoga.footballleague.repodata.Repository
import kotlinx.android.synthetic.main.fragment_league.*
import org.jetbrains.anko.startActivity

/**
 * A simple [Fragment] subclass.
 */
class LeagueFragment : Fragment(), MatchIntf {

    private var items: MutableList<LeagueData> = mutableListOf()
    private var events: MutableList<EventDetail> = mutableListOf()
    private lateinit var presenter: MatchPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = resources.getStringArray(R.array.name_list)
        val image = resources.obtainTypedArray(R.array.image_list)
        val idleague = resources.getStringArray(R.array.id_league)
        for (i in name.indices) {
            items.add(LeagueData(name[i], image.getResourceId(i, 0), idleague[i]))
        }
        presenter = MatchPresenter(this, Repository())
        rv_league.adapter = TeamAdapter(items)
        rv_league.layoutManager = LinearLayoutManager(context)
        btn_search.setOnClickListener {
            val event = edt_search.text.toString()
            if (event.isEmpty()) {
                rv_league.adapter = TeamAdapter(items)
                rv_league.layoutManager = LinearLayoutManager(context)
            } else {
                presenter.getEvents(event)
            }

        }

    }

    override fun DataLoad(data: EventList?) {
        if (data?.event == null) {
            rv_league.invisible()
        } else {

            data.event.let {
                val filter = data.event.filter {
                    it.strSport == "Soccer"
                }
                events.clear()
                events.addAll(filter)
            }
            rv_league.adapter = MatchAdapter(events) {
                context?.startActivity<DetailMatch>(
                    "id" to "${it.idEvent}",
                    "nameHome" to "${it.strHomeTeam}", "nameAway" to "${it.strAwayTeam}"
                )
            }
            rv_league.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDataError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
