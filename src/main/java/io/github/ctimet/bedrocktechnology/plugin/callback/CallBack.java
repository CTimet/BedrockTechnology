package io.github.ctimet.bedrocktechnology.plugin.callback;

import io.github.ctimet.bedrocktechnology.plugin.callback.record.Run;
import io.github.ctimet.bedrocktechnology.plugin.callback.record.CallBackTask;
import io.github.ctimet.bedrocktechnology.plugin.callback.type.Type;
import org.bukkit.event.Event;

import java.util.HashMap;

public class CallBack {
    private static final HashMap<Type, CallBackTask> TASK = new HashMap<>();
    private CallBack() {
    }
    public static Task listen(Type type) {
        return new Task(type);
    }
    public static void put(Type type, Run r1, Runnable r2) {
        TASK.put(type, new CallBackTask(r1, r2));
    }
    public static void callEvent(Type type, Event event) {
        CallBackTask task;
        if ((task = TASK.remove(type)) != null) {
            task.getRun().run(event);
            task.getRunnable().run();
        }
    }
}
