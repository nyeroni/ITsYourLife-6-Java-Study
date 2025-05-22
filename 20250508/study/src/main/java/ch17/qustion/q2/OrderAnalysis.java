package ch17.qustion.q2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderAnalysis {
    public static void main(String[] args) {
        // 제품 목록 생성
        Product laptop = new Product("노트북", "전자제품", 1200000);
        Product phone = new Product("스마트폰", "전자제품", 800000);
        Product book = new Product("자바 책", "도서", 30000);
        Product headphone = new Product("헤드폰", "전자제품", 120000);
        Product tablet = new Product("태블릿", "전자제품", 500000);
        Product charger = new Product("충전기", "액세서리", 25000);

        // 주문 목록 생성
        List<Order> orders = Arrays.asList(
                new Order(1, "김철수", Arrays.asList(laptop, headphone), LocalDate.of(2023, 3, 15)),
                new Order(2, "이영희", Arrays.asList(phone, charger), LocalDate.of(2023, 4, 20)),
                new Order(3, "박민수", Arrays.asList(book, tablet), LocalDate.of(2023, 5, 10)),
                new Order(4, "최지원", Arrays.asList(laptop, phone, charger), LocalDate.of(2023, 5, 22)),
                new Order(5, "김철수", Arrays.asList(tablet, book), LocalDate.of(2023, 6, 5))
        );


        // 1. 총액이 100만원 이상인 주문의 ID 목록을 반환하기
        // 결과: [1, 4]

        // 2. 각 고객별 총 주문 금액을 계산하여 맵으로 반환하기
        // 결과: {김철수=1850000.0, 이영희=825000.0, 박민수=530000.0, 최지원=2025000.0}

        // 3. 모든 주문에서 가장 많이 구매된 제품 카테고리를 찾기
        // 결과: 전자제품

        // 4. 2023년 5월 이후의 주문에서 구매된 모든 제품의 이름을 중복 없이 반환하기
        // 결과: [자바 책, 태블릿, 노트북, 스마트폰, 충전기]

        // 5. 각 제품 카테고리별 평균 가격을 계산하기
        // 결과: {전자제품=655000.0, 도서=30000.0, 액세서리=25000.0}







        // 6. 모든 주문을 날짜별로 그룹화하고, 각 날짜의 총 주문 금액을 계산하기
        // 결과: {2023-03-15=1320000.0, 2023-04-20=825000.0, 2023-05-10=530000.0, 2023-05-22=2025000.0, 2023-06-05=530000.0}
        Map<LocalDate, Double> answer6 = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getOrderDate,
                        Collectors.summingDouble(Order::getTotalAmount)
                ));  // 날짜별로 그룹화 후 총 금액 합산

        System.out.println("" + answer6);


    }
}