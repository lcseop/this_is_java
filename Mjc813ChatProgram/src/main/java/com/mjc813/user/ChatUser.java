package com.mjc813.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.Socket;

@Getter
@AllArgsConstructor
public class ChatUser {
    private String name;
    private Socket socket;

    @Override
    public int hashCode() {
        return socket.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ChatUser cu) {
            if (this.socket == null || cu.getSocket() == null) {
                return false;
            }
            return this.socket.hashCode() == cu.getSocket().hashCode();
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(this.name);
    }
}
