package meta1203.AutoHouse;

import java.io.File;
import java.util.HashMap;

import meta1203.ProofOfConcept.BlockVar;
import meta1203.ProofOfConcept.ProofOfConcept;

import org.bukkit.entity.Player;
import org.bukkit.Server;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;

/**
 * AutoHouse for Bukkit
 *
 * @author meta1203
 */
public class AutoHouse extends JavaPlugin {
    private final AutoHousePlayerListener playerListener = new AutoHousePlayerListener(this);
    private final AutoHouseBlockListener blockListener = new AutoHouseBlockListener(this);
    private final HashMap<Player, Boolean> debugees = new HashMap<Player, Boolean>();
    public ProofOfConcept proof;
    BlockVar houseGen = new BlockVar(120,net.minecraft.server.Material.WOOD, 1F);
    BlockVar inside = new BlockVar(121,net.minecraft.server.Material.WOOD, 1F);
    BlockVar outside = new BlockVar(122,net.minecraft.server.Material.WOOD, 1F);
    int[][][] house = new int[5][5][5];
    

    public AutoHouse() {
        // TODO: Place any custom initialisation code here
        // NOTE: Event registration should be done in onEnable not here as all events are unregistered when a plugin is disabled
    	for(int x = 0; x < house.length; x++) {
    		for(int y = 0; y < house[x].length; y++) {
    			for(int z = 0; z < house[x][y].length; z++) {
    				if (z == 0 || z == 4) {
    					house[x][y][z] = 5;
    				}
    				if (x == 0 || x == 4) {
    					house[x][y][z] = 5;
    				}
    				if (y == 0 || y == 4) {
    					house[x][y][z] = 5;
    				}
    				if ((x == 2 && z == 0 && y == 1) || (x == 2 && z == 0 && y == 2)) {
    					house[x][y][z] = 0;
    				}
    				if (x == 1 && z == 1 && y == 1) {
    					house[x][y][z] = 54;
    				}
    				if (x == 3 && z == 1 && y == 1) {
    					house[x][y][z] = 0;
    				}
    			}
    		}
    	}
    }

   

    public void onEnable() {
        // TODO: Place any custom enable code here including the registration of any events

        // Register our events
        PluginManager pm = getServer().getPluginManager();
        
        Plugin plug = pm.getPlugin("ProofOfConcept");
        if (plug == null) {
        	System.out.println("Could Not Find ProofOfConcept, disabling!");
        }
        proof = (ProofOfConcept)plug;
        proof.newBlock(120, 1F, 1F, 8, new int[] {25,25,26,26,26,27}, 22, "AutoMagical House Maker");
        proof.newBlock(121, 1F, 1F, 8, new int[] {0,43,44,45,45,45}, 22, "Inside of House");
        proof.newBlock(122, 1F, 1F, 8, new int[] {20,20,20,20,20,20}, 22, "Outside of House");
        
        pm.registerEvent(Event.Type.PLAYER_INTERACT, playerListener, Priority.Monitor, this);

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        PluginDescriptionFile pdfFile = this.getDescription();
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }
    public void onDisable() {
        // TODO: Place any custom disable code here

        // NOTE: All registered events are automatically unregistered when a plugin is disabled

        // EXAMPLE: Custom code, here we just output some info so we can check all is well
        System.out.println("Goodbye world!");
    }
    public boolean isDebugging(final Player player) {
        if (debugees.containsKey(player)) {
            return debugees.get(player);
        } else {
            return false;
        }
    }

    public void setDebugging(final Player player, final boolean value) {
        debugees.put(player, value);
    }
}

