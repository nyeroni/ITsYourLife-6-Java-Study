package org.scoula.travel.app;

import java.util.Scanner;
import org.scoula.database.JDBCUtil;
import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.service.TravelService;
import org.scoula.travel.service.TravelServiceImpl;

public class TravelApp {
    Scanner sc = new Scanner(System.in);
    private TravelService service;
    private MenuItem[]menu;

    public TravelApp() {
        TravelDao dao = new TravelDaoImpl();
        service = new TravelServiceImpl(dao);

        menu = new MenuItem[] {
                new MenuItem("전체목록", service::printTravels),
                new MenuItem("페이지목록", service::printTravelsByPage),
                new MenuItem("권역별목록", service::printTravelsByDistrict),
                new MenuItem("상세보기", service::printTravel),
                new MenuItem("종료", this::exit),
        };
    }

    public static void main(String[] args) {
        TravelApp app = new TravelApp();
        app.run();
    }

    public void run() {
        while(true) {
            printMenu();
            int ix = getMenuIndex();

            Runnable command = menu[ix].getCommand();
            command.run();
        }
    }

    public void exit() {
        sc.close();
        JDBCUtil.close();
        System.exit(0);
    }

    public void printMenu() {
        System.out.println("==========================================================================");
        for (int i = 0; i < menu.length; i++) {
            MenuItem menuItem = menu[i];

            // 1부터 시작하는 번호와 메뉴 제목 출력
            System.out.printf("%d) %s ", i + 1, menuItem.getTitle());
        }
        System.out.println();
        System.out.println("==========================================================================");
    }

    public int getMenuIndex() {
        System.out.print("선택: ");
        String line = sc.nextLine();
        int ix = Integer.parseInt(line) - 1;
        return ix;
    }

}
