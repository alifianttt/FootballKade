package com.yoga.footballleague.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yoga.footballleague.R
import com.yoga.footballleague.adapter.FavoriteAdapter
import com.yoga.footballleague.db.database
import com.yoga.footballleague.matchdetail.DetailMatch
import com.yoga.footballleague.model.FavoriteMatch
import kotlinx.android.synthetic.main.fragment_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity

/**
 * A simple [Fragment] subclass.
 */
class FavoriteFragment : Fragment() {

    private var favorites: MutableList<FavoriteMatch> = mutableListOf()
    private lateinit var adapter: FavoriteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FavoriteAdapter(favorites) {
            context?.startActivity<DetailMatch>(
                "id" to "${it.idEvent}",
                "nameHome" to "${it.teamHomeName}", "nameAway" to "${it.teamAwayName}"
            )
        }
        rv_fav.adapter = adapter
        rv_fav.layoutManager = LinearLayoutManager(context)
        showFav()
        Log.d("Data db", favorites.toString())
    }

    override fun onResume() {
        super.onResume()
        showFav()
    }

    private fun showFav() {
        favorites.clear()
        context?.database?.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }
}
