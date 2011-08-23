package meta1203.AutoHouse;

import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.Material;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;

/**
 * AutoHouse block listener
 * @author meta1203
 */
public class AutoHouseBlockListener extends BlockListener {
    private final AutoHouse plugin;

    public AutoHouseBlockListener(final AutoHouse plugin) {
        this.plugin = plugin;
    }

    //put all Block related code here
}
