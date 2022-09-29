package com.geekbrains;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingListTest {
    @Test
    void testPostShoppingList() {

        Item actually = RestAssured.given()
                .queryParam("username", "test4")
                .queryParam("hash", "4b5v4398573406")
                .body("{\n" +
                        "\t\"item\": \"1 package flour powder\",\n" +
                        "\t\"aisle\": \"flour\",\n" +
                        "\t\"parse\": true\n" +
                        "}")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("mealplanner/test4/shopping-list/items")
                .body()
                .as(Item.class);

        System.out.println(actually);

        Assertions.assertEquals(actually.getName(), "flour powder");
        Assertions.assertNotNull(actually.getId());
    }

    @Test
    void testGetPostShoppingList() {

        Item actually = RestAssured.given()
                .queryParam("username", "test4")
                .queryParam("hash", "4b5v4398573406")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("mealplanner/test4/shopping-list")
                .body()
                .as(Item.class);

        System.out.println(actually);

        Assertions.assertNotNull(actually.getStartDate());
        Assertions.assertNull(actually.getPantryItem());

    }
    @Test
    void testDeletePostShoppingList(){
        Item actually = RestAssured.given()
                .queryParam("username", "test4")
                .queryParam("hash", "4b5v4398573406")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .delete("mealplanner/test4/shopping-list/items/15678")
                .body()
                .as(Item.class);


        System.out.println(actually);

    }


}

