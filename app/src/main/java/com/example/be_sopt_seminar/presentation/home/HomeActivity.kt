package com.example.be_sopt_seminar.presentation.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.be_sopt_seminar.data.RepositoryInfo
import com.example.be_sopt_seminar.databinding.ActivityHomeBinding
import com.example.be_sopt_seminar.presentation.home.userInfo.UserInfoActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var repositoryAdapter: RepositoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        moreButtonClickEvent()

        repositoryAdapter = RepositoryAdapter()
        binding.homeRcv.adapter = repositoryAdapter
        repositoryAdapter.repoList.addAll(
            listOf<RepositoryInfo>(
                RepositoryInfo(
                    repositoryName = "Rimi_Sungrim",
                    repositoryDescription = "성림",
                    repositoryLanguage = "Kotlin"
                ),
                RepositoryInfo(
                    repositoryName = "Semi_Semin",
                    repositoryDescription = "세민",
                    repositoryLanguage = "Kotlin"
                ),
                RepositoryInfo(
                    repositoryName = "Joy_Seunghee",
                    repositoryDescription = "승희",
                    repositoryLanguage = "Kotlin"
                ),
                RepositoryInfo(
                    repositoryName = "Lucy_Eungyul",
                    repositoryDescription = "은결",
                    repositoryLanguage = "Kotlin"
                ),
                RepositoryInfo(
                    repositoryName = "Rimi_Sungrim",
                    repositoryDescription = "성림",
                    repositoryLanguage = "Kotlin"
                ),
                RepositoryInfo(
                    repositoryName = "Semi_Semin",
                    repositoryDescription = "세민",
                    repositoryLanguage = "Kotlin"
                ),
                RepositoryInfo(
                    repositoryName = "Joy_Seunghee",
                    repositoryDescription = "승희",
                    repositoryLanguage = "Kotlin"
                ),
                RepositoryInfo(
                    repositoryName = "Lucy_Eungyul",
                    repositoryDescription = "은결",
                    repositoryLanguage = "Kotlin"
                ),
                RepositoryInfo(
                    repositoryName = "이거느느ㅡㅡ으ㅡㅡㄴ와로ㅓㅏ 레포이름이길ㄴ어ㅏㅓ라ㅓㅏㅏㅣㅓㅏㅣㅓㅓㅓㅣㅏ",
                    repositoryDescription = "설명도기러아ㅓㅏ어러ㅓㅓ러러러럴러ㅓㅓ러ㅓㅓㅓㅓㅓㅓㅓ아러ㅏ어ㅏㅣ러ㅏㅓ니ㅓ라ㅓ너라ㅓㅇㄴ리ㅓㅣ마ㅓㅏ러이너ㅣ라ㅓ니ㅏ머라ㅣ너미ㅏㅓㅇ리",
                    repositoryLanguage = "Kotlin"
                )
            )
        )
        repositoryAdapter.notifyDataSetChanged()
    }

    private fun moreButtonClickEvent() {
        binding.homeClMoreBtn.setOnClickListener {
            val intent = Intent(this@HomeActivity, UserInfoActivity::class.java)
            startActivity(intent)
        }
    }
}