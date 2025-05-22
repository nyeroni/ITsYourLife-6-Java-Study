package org.scoula.travel.dao;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.database.JDBCUtil;
import org.scoula.travel.domain.TravelVO;

class TravelDaoTest {
    private TravelDao dao = new TravelDaoImpl();

    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    @DisplayName("전체 여행지 개수 조회")
    @Test
    void getTotalCount() {
        int count = dao.getTotalCount();
        assertTrue(count > 0, "여행지 없음");
        System.out.println("여행지 count = " + count);
    }

    @Test
    @DisplayName("모든 지역(권역) 목록 조회")
    void getDistricts() {

        List<String> districts = dao.getDistricts();

        assertNotNull(districts, "지역 목록 null임");
        assertFalse(districts.isEmpty(), "지역 목록 없음");

        System.out.println("=== 지역 목록 ===");
        districts.forEach(System.out::println);

    }

    @Test
    @DisplayName("전체 여행지 목록 조회")
    void getTravels() {

        List<TravelVO> travels = dao.getTravels();

        assertNotNull(travels, "여행지 목록 null임");
        assertFalse(travels.isEmpty(), "여행지 목록 없음");

        System.out.println("=== 전체 여행지 목록 ===");
        travels.forEach(travel -> System.out.println(travel.getDistrict() + " - " + travel.getTitle()));

        System.out.println("총 여행지 개수 : " + travels.size());
    }


    @Test
    @DisplayName("페이지별 여행지 목록 조회")
    void testGetTravels() {

        int page = 1;

        List<TravelVO> travels = dao.getTravels(page);

        assertNotNull(travels, "페이징된 여행지 목록 null임");
        assertFalse(travels.isEmpty(), "페이징된 여행지 목록 없음");
        assertTrue(travels.size() <= 10, "페이지당 최대 10개 초과");

        System.out.println("=== "+ page + "페이지 여행지 목록 ===");
        travels.forEach(travel ->
                System.out.println(travel.getNo() + ": " + travel.getDistrict() + " - " + travel.getTitle()));

        System.out.println(page + "페이지 여행지 개수 : " + travels.size());
    }
    @Test
    @DisplayName("특정 지역 여행지 목록 조회")
    void testGetTravels1() {

        String district = "강원권";

        List<TravelVO> travels = dao.getTravels(district);

        assertNotNull(travels, "지역별 여행지 목록 null임");

        System.out.println("=== '" + district + "' 여행지 목록 ===");
        travels.forEach(travel ->
                System.out.println(travel.getNo() + ": " + travel.getTitle()));

        System.out.println("'" + district + "' 여행지 개수 :  " + travels.size() + "개");
    }

    @Test
    @DisplayName("특정 여행지 상세 정보 조회")
    void getTravel() {

        Long travelNo = 1L;

        Optional<TravelVO> optionalTravel = dao.getTravel(travelNo);

        assertTrue(optionalTravel.isPresent(), "해당 번호의 여행지 정보가 없음");

        TravelVO travel = optionalTravel.get();

        System.out.println("=== 여행지 상세 정보 ===");
        System.out.println("번호: " + travel.getNo());
        System.out.println("지역: " + travel.getDistrict());
        System.out.println("제목: " + travel.getTitle());
        System.out.println("설명: " + travel.getDescription());
        System.out.println("주소: " + travel.getAddress());
        System.out.println("전화번호: " + travel.getPhone());

        if (travel.getImages() != null && !travel.getImages().isEmpty()) {
            System.out.println("=== 연관 이미지 정보 ===");
            travel.getImages().forEach(image ->
                    System.out.println("- " + image.getFilename()));
        } else {
            System.out.println("연관된 이미지가 없습니다.");
        }
    }
}