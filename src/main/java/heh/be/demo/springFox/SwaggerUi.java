/*package heh.be.demo.springFox;

import heh.be.demo.vue.Country;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SwaggerUi {
    @ApiOperation("Calculate the distance (in meters) that a frisbee would travel")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Distance (in meters)")
    })
    @GetMapping(value = "/frisbee/distance/{force}/{angle}")
    public Country getDistance(
            @ApiParam("The force (in Newtons) with which the disc was thrown")
            @PathVariable("force")
            final double force,
            @ApiParam("The angle-of-attack of the disc (in degrees)")
            @PathVariable("angle")
            final double angle
    ){
        double distance = frisbeeService.getDistance(force, angle);
        return new FrisbeeThrowDTO(force, angle, distance);
        // à modifier
    }
}*/



