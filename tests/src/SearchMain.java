package src;

import app.Main;
import app.SearchUseCaseFactory;
import data_access.ProductDAO;
import entity.ProductFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.search.SearchViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.SearchView;
import view.SignupView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import static org.junit.Assert.assertNotNull;

public class SearchMain
{
    static String message = "";
    static boolean popUpDiscovered = false;
    @BeforeEach
    public static void setUp() throws IOException
    {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Search test");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SearchViewModel searchViewModel = new SearchViewModel();

        FileWriter fileWriter = new FileWriter("empty.csv");
        String header = "id,title,inventory,URL,price";
        fileWriter.write(header);
        fileWriter.close();
        ProductDAO pdDAO = new ProductDAO("empty.csv", new ProductFactory());

        view.SearchView searchView = SearchUseCaseFactory.create(viewManagerModel, searchViewModel, pdDAO);
        assert searchView != null;
        views.add(searchView, searchView.viewName);


        viewManagerModel.setActiveView(searchView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }

    public JButton getButton1() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        SignupView sv = (SignupView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(4);

        return (JButton) buttons.getComponent(0); // this should be the search button
    }
    public JButton getButton2() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        SignupView sv = (SignupView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(4);

        return (JButton) buttons.getComponent(1); // this should be the search button
    }
    @org.junit.Test
    public void testSearchButtonPresent() throws MalformedURLException {
        Main.main(null);
        JButton button = getButton1();
        assert(button.getText().equals("GO!"));
    }
    @org.junit.Test
    public void testReturnButtonPresent() throws MalformedURLException {
        Main.main(null);
        JButton button = getButton2();
        assert(button.getText().equals("return"));
    }

    @org.junit.Test
    public void testSearchPopUpShown() throws MalformedURLException {

        popUpDiscovered = false;

        Main.main(null);
        JFrame app = null;

        JButton button = getButton1();

        // since clicking the button should end up displaying a JDialog to the user to report the
        // result, we set a timer, which will execute code necessary to complete the testing.
        createCloseTimer().start();

        //click the button
        button.doClick();

        // will continue execution here after the JDialog is closed

        // confirm a popUp was discovered
        assert(popUpDiscovered);
        System.out.println("popup was detected successfully.");

    }
    private Timer createCloseTimer() {
        ActionListener close = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Window[] windows = Window.getWindows();
                for (Window window : windows) {

                    if (window instanceof JDialog) {

                        JDialog dialog = (JDialog)window;

                        // this ignores old dialogs
                        if (dialog.isVisible()) {
                            String s = ((JOptionPane) ((BorderLayout) dialog.getRootPane()
                                    .getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).getMessage().toString();
                            System.out.println("message = " + s);

                            // store the information we got from the JDialog
                            SearchMain.message = s;
                            SearchMain.popUpDiscovered = true;

                            System.out.println("disposing of..." + window.getClass());
                            window.dispose();
                        }
                    }
                }
            }

        };

        Timer t = new Timer(1000, close);
        t.setRepeats(false);
        return t;
    }

}
