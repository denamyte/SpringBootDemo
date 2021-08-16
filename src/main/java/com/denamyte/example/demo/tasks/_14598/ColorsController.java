package com.denamyte.example.demo.tasks._14598;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @see <a href="https://hyperskill.org/learn/daily/14598">Getting data from REST -> Return big JSON</a>
 */
@RestController
@RequestMapping("/14598")
public class ColorsController {

    @GetMapping("/colors")
    public ResponseEntity<Map<String, Collection<Color>>> getColors() {
        return ResponseEntity.ok().body(Map.of(
                "colors", List.of(ColorFactory.getBlack(), ColorFactory.getWhite()
        )));
    }

    static class Color {
        public String color;
        public String category;
        public String type;
        public ColorCode code;

    }

    static class ColorCode {
        public List<Integer> rgba;
        public String hex;
    }


    static class ColorFactory {
        static Color getBlack() {
            Color color = new Color();
            color.color = "black";
            color.category = "hue";
            color.type = "primary";

            ColorCode code = new ColorCode();
            code.rgba = Arrays.asList(255, 255, 255, 1);
            code.hex = "#000";
            color.code = code;
            return color;
        }

        static Color getWhite() {
            Color color = new Color();
            color.color = "white";
            color.category = "value";
            color.type = "primary";

            ColorCode code = new ColorCode();
            code.rgba = Arrays.asList(0, 0, 0, 1);
            code.hex = "#FFF";
            color.code = code;
            return color;
        }
    }

}
