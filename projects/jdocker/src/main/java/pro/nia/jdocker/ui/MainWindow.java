package pro.nia.jdocker.ui;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import pro.nia.jdocker.controller.AppController;
import pro.nia.jdocker.ui.pages.containers.ContainersPage;
import pro.nia.jdocker.ui.pages.images.ImagesPage;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
    private String title_prefix = "JDocker";
    // IController _controller;
    ToolbarView _toolbar;
    // JPanel _explorer;
    JTabbedPane _tabs;
    ActionsBarView _actions_bar;

    ContainersPage _containers_page;
    // ImagesPage _images_page;

    AppController _app_controller;

    public MainWindow(AppController app_controller) {

        // controller
        _app_controller = app_controller;

        // menu
        JMenuBar main_menu = new JMenuBar();
        this.setJMenuBar(main_menu);

        main_menu.add(create_file_menu());

        // добавление и настройка компонент -----------------------------------
        Container container = getContentPane(); // клиентская область окна
        container.setLayout(new BorderLayout()); // выбираем компоновщик

        // tool bar -----------------------------------------------------------
        _toolbar = new ToolbarView();
        container.add(_toolbar, BorderLayout.NORTH);

        // tabs ---------------------------------------------------------------
        _tabs = new JTabbedPane();
        container.add(_tabs, BorderLayout.CENTER);

        _containers_page = new ContainersPage(_app_controller.get_containers_controller());
        _tabs.addTab("Containers", _containers_page);
        _tabs.addTab("Images", new ImagesPage(_app_controller.get_images_controller()));
        // _tabs.addTab("Volumes", _containers_page);
        // _tabs.addTab("Networks", _containers_page);
        // _tabs.addTab("Configs", _containers_page);
        // _tabs.addTab("Secrets", _containers_page);

        // actions bar --------------------------------------------------------
        _actions_bar = new ActionsBarView();
        container.add(_actions_bar, BorderLayout.SOUTH);

        // настройка окна -----------------------------------------------------
        setTitle(this.title_prefix);
        setPreferredSize(new Dimension(1024, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }

    // запуск оконного приложения
    // public static void main(String args[]) {
    // new MyWin();
    // }

    private JMenu create_file_menu() {
        // Создание выпадающего меню
        JMenu file = new JMenu("Файл");
        // Пункт меню "Открыть" с изображением
        JMenuItem open = new JMenuItem("Открыть",
                new ImageIcon("images/open.png"));
        // Пункт меню из команды с выходом из программы
        JMenuItem exit = new JMenuItem(new ExitAction());
        // Добавление к пункту меню изображения
        exit.setIcon(new ImageIcon("images/exit.png"));
        // Добавим в меню пункта open
        file.add(open);
        // Добавление разделителя
        file.addSeparator();
        file.add(exit);

        // NOTE:
        // https://www.codejava.net/java-core/the-java-language/java-8-lambda-listener-example
        // open.addActionListener(e -> {
        // System.out.println("ActionListener.actionPerformed : open");

        // // JFileChooser fileChooser = new JFileChooser();
        // // fileChooser.setCurrentDirectory(new
        // File(System.getProperty("user.home")));
        // // int result = fileChooser.showOpenDialog(this._explorer);
        // // if (result == JFileChooser.APPROVE_OPTION) {
        // // File selectedFile = fileChooser.getSelectedFile();
        // // this._controller.open_db(selectedFile.getAbsolutePath());
        // // }

        // });
        return file;
    }

    /**
     * Вложенный класс завершения работы приложения
     */
    class ExitAction extends AbstractAction {
        private static final long serialVersionUID = 1L;

        ExitAction() {
            putValue(NAME, "Выход");
        }

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // enable anti-aliased text:
        System.setProperty("awt.useSystemAAFontSettings", "on");

        SwingUtilities.invokeLater(() -> {

            // new MainWindow(new AppController());
        });
    }
}
