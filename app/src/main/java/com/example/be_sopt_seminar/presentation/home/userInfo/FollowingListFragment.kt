package com.example.be_sopt_seminar.presentation.home.userInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.be_sopt_seminar.data.FollowingUserInfo
import com.example.be_sopt_seminar.databinding.FragmentFollowingListBinding
import com.example.be_sopt_seminar.presentation.home.userInfo.FollowingListAdapter

class FollowingListFragment : Fragment() {

    private var _binding: FragmentFollowingListBinding? = null
    private val binding get() = _binding ?: error("View 를 참조하기위해 binding 이 초기화 되지 않았습니다.")

    private lateinit var followingListAdapter: FollowingListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        followingListAdapter = FollowingListAdapter()
        binding.userList.adapter = followingListAdapter
        followingListAdapter.userList.addAll(
            listOf<FollowingUserInfo>(
                FollowingUserInfo(
                    userImage = "",
                    userName = "cutthebutter"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "CHOSUNGRIM"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "lydiacho"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "hongeungual"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "cutthebutter"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "CHOSUNGRIM"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "lydiacho"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "hongeungual"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "cutthebutter"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "CHOSUNGRIM"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "lydiacho"
                ),
                FollowingUserInfo(
                    userImage = "",
                    userName = "hongeungual"
                )
            )
        )

        followingListAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}