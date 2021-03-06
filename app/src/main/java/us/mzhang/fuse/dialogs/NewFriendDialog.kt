package us.mzhang.fuse.dialogs

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.new_friend_layout.view.*
import us.mzhang.fuse.R
import us.mzhang.fuse.adapter.MediaAdapter
import us.mzhang.fuse.data.User

class NewFriendDialog : DialogFragment() {

    lateinit var mediaAdapter: MediaAdapter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())

        var newFriend: User = (arguments?.getSerializable("USER") as User)

        builder.setTitle(newFriend.username)

        val rootView = requireActivity().layoutInflater.inflate(
            R.layout.new_friend_layout, null
        )

        mediaAdapter = MediaAdapter(context!!, newFriend)

        mediaAdapter.mediaList = newFriend.socialSet.keys.toMutableList()

        rootView.recyclerView.adapter = mediaAdapter
        builder.setView(rootView)


        return builder.create()
    }
}