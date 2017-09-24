package spittr.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.Spittle;
import spittr.data.SpittleRepository;

/**
 * Spring MVC provides several ways that a client can pass data into a controller’s handler method. These include
 * Query parameters, Form parameters, and Path variables.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    // query parameters are always of type String, the defaultValue attribute requires a String value
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";// Long.toString(Long.MAX_VALUE)

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /**
     * <p>
     * Rather than return a logical view name and explicitly setting the model, this method returns the Spittle list.
     * When a handler method returns an object or a collection like this, the value returned is put into the model,
     * and the model key is inferred from its type (spittleList, as in the other examples).
     * <p>
     * As for the logical view name, it’s inferred from the request path. Because this method handles GET requests
     * for /spittles, the view name is spittles (chopping off the leading slash)
     *
     * @param max
     * @param count
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    // The Model is essentially a map (that is, a collection of key-value pairs) that will be handed off to the view
    // so that the data can be rendered to the client.
//  @RequestMapping(method=RequestMethod.GET)
//  public String spittles(Model model) {
//    model.addAttribute(
//            spittleRepository.findSpittles(
//                    Long.MAX_VALUE, 20));
//    return "spittles";// return spittles as the name of the view that will render the model.
//  }

    /**
     * not ideal from a resource-orientation perspective. Ideally, the resource being identified (the Spittle)
     * would be identified by the URL path, not by query parameters. /spittles/12345
     * <p>
     * Because the method parameter name happens to be the same as the placeholder name, you can optionally omit
     * the value parameter on @PathVariable.
     *
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) throws Exception {
        spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
                form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }

    /**
     * /spittles/show?spittle_id=12345 describes an operation with a parameter—essentially RPC over HTTP
     *
     * @param spittleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId,
            Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittle";
    }

}
