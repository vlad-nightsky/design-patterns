package ru.nightsky.patterns.proxy.virtalProxy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Виртуальный заместитель сначала выводит сообщение, а затем после завершения загрузки передаёт управление ImageIcon
 */
public class ImageProxy implements Icon {
    /**
     * В переменной imageIcon храниться НАСТОЯЩИЙ объект Icon, который должен отображаться после загрузки
     */
    ImageIcon imageIcon;
    URL imageURL;
    Thread retrievalThread;
    boolean retrieving = false;

    /**
     * в конструктор передаётся URL адрес изображения - того, которое должно отображаться после загрузки
     */
    public ImageProxy(URL imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null)
            imageIcon.paintIcon(c, g, x, y);
        else {
            g.drawString("Загрузка CD обложки, пожалуйста подождите...", x + 300, y + 190);
            if(!retrieving){
                retrieving = true;
                retrievalThread = new Thread(new Runnable() {
                    //Здесь происходит самое интересное. Изображение прорисовывается на экране (вызов делегируется imageIcon)
                    //Но если объект imageIcon ещё не создан, мы создаём его
                    @Override
                    public void run() {
                        try {
                            imageIcon = new ImageIcon(imageURL, "CD Cover");
                            c.repaint();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon != null)
            return imageIcon.getIconWidth();
        else
            return 800;
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null)
            return imageIcon.getIconHeight();
        else
            return 600;
    }
}
