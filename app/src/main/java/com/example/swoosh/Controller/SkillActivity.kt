package com.example.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.swoosh.R
import com.example.swoosh.Utilities.EXTRA_LEAGUE
import com.example.swoosh.Utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    fun onBeginnerClicked(v: View) {
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }

    fun onBallerClicked(v: View) {
        beginnerSkillBtn.isChecked = false
        skill = "baller"
    }

    fun checkSkillBtns(): Boolean {
        return (beginnerSkillBtn.isChecked || ballerSkillBtn.isChecked)
    }

    fun onFinishClicked(view: View) {
        if (skill != "" && checkSkillBtns()) {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
        }
    }
}
