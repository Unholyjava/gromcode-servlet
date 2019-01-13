package lesson_2;

public class ItemService {
	private ItemDAO itemDao;

	public ItemService(ItemDAO itemDao) {
		this.itemDao = itemDao;
	}
	
	public Item createItemService(Item item) throws Exception {
		return itemDao.save(item);
	}
	
	public Item updateItemService(Item item) throws Exception {
		return itemDao.update(item);
	}
	
	public Item readItemService(long id) throws Exception {
		return itemDao.findById(id);
	}
	
	public Item deleteItemService(long id) throws Exception {
		return itemDao.delete(id);
	}
	
}
