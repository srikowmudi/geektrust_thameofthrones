package com.example.universe;

public interface IWarProtocol {
    String decryptMessage(String message);
    int isEmblemInMsg(String message);
    void recordVictoryStatus(int victory);
}
