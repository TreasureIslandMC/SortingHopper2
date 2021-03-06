package point3d.sortinghopper2;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.inventory.Inventory;

/**
 * Listener for pickup event, if disabled in the config.
 */
public class PickupListener implements Listener {
	private final SortingHopper plugin;      
	public PickupListener(SortingHopper plugin) {
		if (plugin == null) {
			throw new IllegalArgumentException("Plugin cannot be null");
		}
		this.plugin = plugin;
	}

	/**
	 * Cancels item pickup for inventory with configured name.
	 *
	 * @param event the pickup event object
	 */
	@EventHandler
	public void onInventoryPickupEvent(InventoryPickupItemEvent event) {
		 Inventory dest = event.getInventory();   
		    if(plugin.getRules().checkLocation(dest.getLocation())){
			event.setCancelled(true);
		}
	}
}
