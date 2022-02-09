package com.example.recyclerviewtutorialproject.repository;

import com.example.recyclerviewtutorialproject.R;
import com.example.recyclerviewtutorialproject.models.ChatList;

import java.util.ArrayList;
import java.util.List;

public class ChatListRepository {
    public static List<ChatList> getUserChatList(){
        List<ChatList> userChatList = new ArrayList();
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));
        userChatList.add(new ChatList(R.drawable.bird,"mehedi","10:40","how are you","------------------------"));

        return userChatList;
    }
}
