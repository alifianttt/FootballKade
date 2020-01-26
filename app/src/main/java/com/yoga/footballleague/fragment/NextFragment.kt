package com.yoga.footballleague.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoga.footballleague.R
import com.yoga.footballleague.adapter.MatchAdapter
import com.yoga.footballleague.behave.invisible
import com.yoga.footballleague.match.MatchIntf
import com.yoga.footballleague.match.MatchPresenter
import com.yoga.footballleague.matchdetail.DetailMatch
import com.yoga.footballleague.model.EventDetail
import com.yoga.footballleague.model.EventList
import com.yoga.footballleague.model.LeagueData
import com.yoga.footballleague.repodata.Repository
import kotlinx.android.synthetic.main.fragment_next.*
import org.jetbrains.anko.startActivity

/**
 * A simple [Fragment] subclass.
 */
class NextFragment : Fragment(), AdapterView.OnItemSelectedListener, MatchIntf {

    private var match: MutableList<EventDetail> = mutableListOf()
    private lateinit var presenter: MatchPresenter
    private var items: MutableList<LeagueData> = mutableListOf()
    private lateinit var idLeague: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = resources.getStringArray(R.array.name_list)
        val image = resources.obtainTypedArray(R.array.image_list)
        val idleague = resources.getStringArray(R.array.id_league)
        for (i in name.indices) {
            items.add(LeagueData(name[i], image.getResourceId(i, 0), idleague[i]))
        }
        spin_match.onItemSelectedListener = this
        spin_match.adapter = activity?.let {
            ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, items)
        }

        presenter = MatchPresenter(this, Repository())
    }

    override fun DataLoad(data: EventList?) {
        if (data?.events == null) {
            rv_next.invisible()
        } else {
            data.events.let {
                match.clear()
                match.addAll(it)
            }
            rv_next.adapter = MatchAdapter(match) {
                context?.startActivity<DetailMatch>(
                    "id" to "${it.idEvent}",
                    "nameHome" to "${it.strHomeTeam}", "nameAway" to "${it.strAwayTeam}"
                )
            }
            rv_next.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDataError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        idLeague = items[p2].idLeague
        presenter.getNextMatch(idLeague)
    }


}
