package com.github.sa_shiro.questmaster.quest;

public enum QuestNames {

    ZOMBIE("kill_zombies"),
    SKELETON("kill_skeletons");

    String questName;

    QuestNames(String name) {
        questName = name;
    }

    public String getName() {
        return questName;
    }
}
