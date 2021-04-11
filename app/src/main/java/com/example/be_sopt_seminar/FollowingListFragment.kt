package com.example.be_sopt_seminar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.be_sopt_seminar.databinding.FragmentFollowingListBinding

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

        // 1. 우리가 사용할 어뎁터의 초기 값을 넣어줍시다!
        followingListAdapter = FollowingListAdapter()

        // 2. RecyclerView 에 어뎁터를 우리가 만든 어뎁터로 만들어줍시다!
        binding.userList.adapter = followingListAdapter

        followingListAdapter.userList.addAll(
            listOf<FollowingUserInfo>(
                FollowingUserInfo(
                    userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                    userName = "jinsu4755"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                    userName = "l2hyunwoo"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                    userName = "SSong-develop"
                ),
                FollowingUserInfo(
                    userImage = "지금은 빈칸! 4차때 넣어봅시다!",
                    userName = "kym1924"
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