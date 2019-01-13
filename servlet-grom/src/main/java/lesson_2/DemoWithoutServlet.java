package lesson_2;

public class DemoWithoutServlet {

	public static void main(String[] args) {
		ItemDAO itemDao = new ItemDAO();
		ItemService itemService = new ItemService(itemDao);
		ItemController itemController = new ItemController(itemService);
//		ItemController itemController = new ItemController(new ItemService(new ItemDAO()));
		
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		Item item4 = new Item();
		item1.setId(1);
		item2.setId(2);
		item3.setId(2);
		item1.setName("Item-1");
		item2.setName("Item-2");
		item3.setName("Item-3");
		
		try {
			itemController.createItem(item1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Сохранение объекта №1\n");
		
		try {
			itemController.createItem(item2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Сохранение объекта №2\n");
		
//		try {
//			itemController.createItem(item4);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Объект №4 не будет сохранен\n");
//		
		try {
			itemController.updateItem(item3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Объект №2 заменен на Объект №3\n");
//		
//		try {
//			System.out.println(itemController.readItem(1));
//			System.out.println(itemController.readItem(2));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Чтение Объектов с id = 1 и id = 2\n");
//		
//		try {
//			itemController.deleteItem(3);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Невозможность удаления Объекта с id = 3\n");
//		
//		try {
//			itemController.deleteItem(1);
//			itemController.deleteItem(2);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Удаление Объектов с id = 1 и id = 2\n");
//		
//		try {
//			System.out.println(itemController.readItem(1));
//			System.out.println(itemController.readItem(2));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("Чтение удаленных Объектов с id = 1 и id = 2\n");
	}

}
