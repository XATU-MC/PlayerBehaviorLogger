package top.xatumc.playerbehaviorlogger.logger;

import net.minecraft.world.entity.player.Player;
import top.xatumc.playerbehaviorlogger.PlayerBehaviorLogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class PlayerLogger {
    private List<String> loggerContext = new ArrayList<>(100);
    private final Player player;
    private File file = null;

    public PlayerLogger(Player player) {
        this.player = player;
    }

    String getNewFileName() {
        String playerName = this.player.getScoreboardName();
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat format = new SimpleDateFormat("-yyyy-MM-dd-hh-mm-ss");
        String time = format.format(calendar.getTime());
        return playerName + time;
    }

    void saveAndCreate(Path dir) {
        this.save(dir, true);
    }

    void save(Path dir) {
        this.save(dir, false);
    }

    void save(Path dir, boolean newFile) {
        String fileName = this.getNewFileName();
        if (newFile || this.file == null) {
            this.file = dir.resolve(fileName).toFile();
            try {
                if (!this.file.isFile())
                    if (this.file.createNewFile())
                        throw new IOException("Create file failed: " + fileName);
            } catch (IOException e) {
                PlayerBehaviorLogger.loggerException(e);
            }
        }
    }

    void load(Path dir) {
    }
}
