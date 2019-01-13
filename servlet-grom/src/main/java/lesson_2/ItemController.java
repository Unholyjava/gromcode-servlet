package lesson_2;

public class ItemController {
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	public Item createItem(Item item) throws Exception {
		return itemService.createItemService(item);
	}
	
	public Item updateItem(Item item) throws Exception {
		return itemService.updateItemService(item);
	}
	
	public Item readItem(long id) throws Exception {
		return itemService.readItemService(id);
	}
	
	public Item deleteItem(long id) throws Exception {
		return itemService.deleteItemService(id);
	}
}
