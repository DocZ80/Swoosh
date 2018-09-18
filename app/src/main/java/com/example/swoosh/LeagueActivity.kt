package com.example.swoosh

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClicked(v: View) {
        if (selectedLeague != "" && checkLeagueBtns()) {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }

    fun checkLeagueBtns(): Boolean {
        return (mensLeagueBtn.isChecked || womensLeagueBtn.isChecked || coedLeagueBtn.isChecked)
    }

    fun onMensClicked(v: View) {
        womensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        selectedLeague = "mens"
    }

    fun onWomensClicked(v: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        selectedLeague = "womens"
    }

    fun onCoedClicked(v: View) {
        mensLeagueBtn.isChecked = false
        womensLeagueBtn.isChecked = false
        selectedLeague = "coed"
    }
}
