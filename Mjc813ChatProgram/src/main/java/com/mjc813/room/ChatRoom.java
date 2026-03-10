package com.mjc813.room;

import com.mjc813.user.ChatUser;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChatRoom {
    private static Long lastRoomId = 1L;
    /**
     * 대화방의 고유 번호, 중복 안됨
     */
    private final Long roomId;
    /**
     * 채팅 유저들의 컬렉션
     */
    private List<ChatUser> users;

    public ChatRoom() {
        this.users = Collections.synchronizedList(new LinkedList<ChatUser>());
        this.roomId = lastRoomId++; // 새로운 방은 id 값을 항상 1 더해서 중복을 피한다.
    }

    /**
     * 방 내의 유저들을 리턴한다.
     * @return ChatUsers
     */
    public List<ChatUser> getAllUsers() {
        return users;
    }

    /**
     * 방의 아이디를 리턴한다.
     * @return roomId
     */
    public Long getRoomId() {
        return roomId;
    }
}
