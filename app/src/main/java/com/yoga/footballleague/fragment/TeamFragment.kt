package com.yoga.footballleague.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoga.footballleague.R
import com.yoga.footballleague.adapter.LeagueAdapter
import com.yoga.footballleague.behave.invisible
import com.yoga.footballleague.detailteam.DetailTeam
import com.yoga.footballleague.main.MainPresenter
import com.yoga.footballleague.main.MainView
import com.yoga.footballleague.model.ClubResponse
import com.yoga.footballleague.model.Clubs
import com.yoga.footballleague.model.LeagueData
import com.yoga.footballleague.repodata.Repository
import kotlinx.android.synthetic.main.fragment_team.*
import org.jetbrains.anko.startActivity

/**
 * A simple [Fragment] subclass.
 */
class TeamFragment : Fragment(), AdapterView.OnItemSelectedListener, MainView {

    private lateinit var adapter: LeagueAdapter
    private var clubs: MutableList<Clubs> = mutableListOf()
    private var items: MutableList<LeagueData> = mutableListOf()
    private lateinit var idLeague: String
    private lateinit var presenter: MainPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = resources.getStringArray(R.array.name_list)
        val image = resources.obtainTypedArray(R.array.image_list)
        val idleague = resources.getStringArray(R.array.id_league)
        for (i in name.indices) {
            items.add(LeagueData(name[i], image.getResourceId(i, 0), idleague[i]))
        }
        spinn_liga.onItemSelectedListener = this
        spinn_liga.adapter =
            activity?.let { ArrayAdapter(it, android.R.layout.simple_spinner_dropdown_item, items) }

        presenter = MainPresenter(this, Repository())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        idLeague = spinn_liga.selectedItem.toString()
        presenter.getTeams(idLeague)
    }

    override fun DataLoad(data: ClubResponse?) {
        if (data?.teams == null) {
            rv_team.invisible()
        } else {
            data.teams.let {
                clubs.clear()
                clubs.addAll(it)
            }
                rv_team?.adapter = LeagueAdapter(clubs){
                    context?.startActivity<DetailTeam>(
                        "idTeam" to "${it.teamId}",
                        "nameTeam" to "${it.teamName}"
                    )
                }
                rv_team?.layoutManager = LinearLayoutManager(context)


        }
    }

    override fun onDataError() {
        Toast.makeText(context, "Gagal Load", Toast.LENGTH_SHORT).show()
    }
}
