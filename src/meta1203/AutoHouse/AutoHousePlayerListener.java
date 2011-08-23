package meta1203.AutoHouse;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Handle events for all Player related events
 * @author meta1203
 */
public class AutoHousePlayerListener extends PlayerListener {
    private final AutoHouse plugin;

    public AutoHousePlayerListener(AutoHouse instance) {
        plugin = instance;
    }

    //Insert Player related code here
    public void onPlayerInteract(PlayerInteractEvent event) {
    	if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock().getTypeId() == 120) {
    		Block origin = event.getClickedBlock();
    		for(int x = 0; x < plugin.house.length; x++) {
        		for(int y = 0; y < plugin.house[x].length; y++) {
        			for(int z = 0; z < plugin.house[x][y].length; z++) {
        				
        			}
        		}
    		}
    	}
    }
}

