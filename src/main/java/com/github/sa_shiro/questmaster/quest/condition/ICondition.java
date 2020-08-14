package com.github.sa_shiro.questmaster.quest.condition;

import com.github.sa_shiro.questmaster.quest.Quest;

public interface ICondition {

    /**
     * @return The current objective status of the {@link Quest}.
     */
    int getCount();

    /**
     * @return How much of the objective is needed to complete the {@link Quest}.
     */
    int getTargetCount();

    /**
     * @return true if the {@link Quest} has been finished.
     */
    boolean isFinished();
}
