package lesson_2;




import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(urlPatterns = "/test")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemController itemController = new ItemController(new ItemService(new ItemDAO()));

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			long id  = Long.valueOf(req.getParameter("itemId"));
			resp.getWriter().println(itemController.readItem(id));
		} catch (Exception e) {
			System.out.println("Error in read-operation");
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	String stringJson = req.getReader().lines().collect(Collectors.joining());
        	JSONObject userJson = new JSONObject(stringJson);
        	long id = userJson.getLong("id");
        	String name = userJson.getString("name");
        	String description = userJson.getString("description");
        	Item userItem = new Item();
        	userItem.setId(id);
        	userItem.setName(name);
        	userItem.setDescription(description);
        	resp.getWriter().println(itemController.createItem(userItem));
        } catch (Exception e) {
        	System.out.println("Error in post-operation");
        	e.printStackTrace();
        }
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
        	String stringJson = req.getReader().lines().collect(Collectors.joining());
        	JSONObject userJson = new JSONObject(stringJson);
        	long id = userJson.getLong("id");
        	String name = userJson.getString("name");
        	String description = userJson.getString("description");
        	Item userItem = new Item();
        	userItem.setId(id);
        	userItem.setName(name);
        	userItem.setDescription(description);
        	resp.getWriter().println(itemController.updateItem(userItem));
        } catch (Exception e) {
        	System.out.println("Error in put-operation");
        	e.printStackTrace();
        }
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			long id  = Long.valueOf(req.getParameter("itemId"));
			resp.getWriter().println(itemController.deleteItem(id));
		} catch (Exception e) {
			System.out.println("Error in delete-operation");
			e.printStackTrace();
		}
	}
}
