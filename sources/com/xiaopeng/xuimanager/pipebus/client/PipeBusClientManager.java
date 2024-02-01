package com.xiaopeng.xuimanager.pipebus.client;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class PipeBusClientManager {
    private static final Map<String, PipeBusClient> clientMap = new ConcurrentHashMap();

    public static synchronized PipeBusClient createBusClient(String serviceName, Context context) {
        PipeBusClient client;
        synchronized (PipeBusClientManager.class) {
            client = clientMap.get(serviceName);
            if (client == null) {
                client = new PipeBusClient(serviceName);
                client.init(context);
                clientMap.put(serviceName, client);
            }
        }
        return client;
    }
}
