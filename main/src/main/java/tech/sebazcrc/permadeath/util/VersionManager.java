package tech.sebazcrc.permadeath.util;

import lombok.Getter;
import org.bukkit.Bukkit;

public class VersionManager {
    @Getter
    private static final String version;
    @Getter
    private static MinecraftVersion minecraftVersion;

    static {
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        
        String[] parts = packageName.split("\\.");
        String ver = null;
        
        for (String part : parts) {
            if (part.startsWith("v")) {
                ver = part.substring(1);
                break;
            }
        }
        
        if (ver == null) {
            ver = "1_15_R1"; 
        }
        version = ver;
        try {
            minecraftVersion = MinecraftVersion.valueOf("v" + ver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getRev() {
        return getVersion();
    }

    public static boolean isValidVersionSet() {
        return minecraftVersion != null;
    }

    public static String getFormattedVersion() {
        return minecraftVersion.getFormattedName();
    }

    public static boolean isRunningPostNetherUpdate() {
        return minecraftVersion != MinecraftVersion.v1_15_R1;
    }
}
