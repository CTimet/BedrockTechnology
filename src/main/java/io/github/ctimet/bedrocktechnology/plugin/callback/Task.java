package io.github.ctimet.bedrocktechnology.plugin.callback;

import io.github.ctimet.bedrocktechnology.plugin.callback.record.Run;
import io.github.ctimet.bedrocktechnology.plugin.callback.record.Store;
import io.github.ctimet.bedrocktechnology.plugin.callback.type.Type;

import java.util.LinkedList;

public class Task {
    private Type type;
    private final LinkedList<Store> Tasks = new LinkedList<>();
    public Task(Type type) {
        this.type = type;
    }

    public Task callBack(Run run) {
        Tasks.add(new Store(this.type, run));
        return this;
    }

    public Task listen(Type type) {
        this.type = type;
        return this;
    }

    public void start() {
        CallBack.put(Tasks.getFirst().getType(), Tasks.getFirst().getRun(), () -> {
            Tasks.removeFirst();
            if (Tasks.isEmpty()) {
                return;
            }
            start();
        });
    }
}
