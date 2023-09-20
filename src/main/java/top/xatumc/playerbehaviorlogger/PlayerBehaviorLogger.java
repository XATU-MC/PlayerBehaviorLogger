package top.xatumc.playerbehaviorlogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class PlayerBehaviorLogger implements ModInitializer {
    public static final Gson GSON = getGsonBuilder().create();
    public static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {

    }

    public static GsonBuilder getGsonBuilder() {
        return new GsonBuilder()
                .setPrettyPrinting();
    }

    public static void loggerException(Exception e) {
        PlayerBehaviorLogger.LOGGER.error(e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            PlayerBehaviorLogger.LOGGER.error(element.toString());
        }
    }
}
