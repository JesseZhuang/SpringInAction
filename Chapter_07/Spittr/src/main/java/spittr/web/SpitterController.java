package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

  private SpitterRepository spitterRepository;

  @Autowired
  public SpitterController(SpitterRepository spitterRepository) {
    this.spitterRepository = spitterRepository;
  }
  
  @RequestMapping(value="/register", method=GET)
  public String showRegistrationForm(Model model) {
    model.addAttribute(new Spitter());
    return "registerForm";
  }

//  If you’re deploying your application to a Servlet 3.0 container
//  @RequestMapping(value="/register", method=POST)
//  public String processRegistration(
//      @RequestPart(value="profilePictures", required=false) Part fileBytes,
//      RedirectAttributes redirectAttributes,
//      @Valid Spitter spitter,
//      Errors errors) throws IOException {
//    if (errors.hasErrors()) {
//      return "registerForm";
//    }
//    profilePicture.write("/data/spittr/" + profilePicture.getOriginalFilename());
//    
//    spitterRepository.save(spitter);
//    redirectAttributes.addAttribute("username", spitter.getUsername());
//    redirectAttributes.addFlashAttribute(spitter);
//    return "redirect:/spitter/" + spitter.getUsername();
//  }
  
  @RequestMapping(value="/register", method=POST)
  public String processRegistration(
      @Valid SpitterForm spitterForm,
      Errors errors) throws IllegalStateException, IOException {
    
    if (errors.hasErrors()) {
      return "registerForm";
    }
    Spitter spitter = spitterForm.toSpitter();
    spitterRepository.save(spitter);
    MultipartFile profilePicture = spitterForm.getProfilePicture();
    profilePicture.transferTo(new File("/tmp/spittr/" + spitter.getUsername() + ".jpg"));
    return "redirect:/spitter/" + spitter.getUsername();
  }
  
  @RequestMapping(value="/{username}", method=GET)
  public String showSpitterProfile(
          @PathVariable String username, Model model) {
    if (!model.containsAttribute("spitter")) {
      model.addAttribute(
          spitterRepository.findByUsername(username));
    }
    return "profile";
  }

//  private void saveImage(MultipartFile image)
//          throws ImageUploadException {
//    try {
        // Set up S3 service
//      AWSCredentials awsCredentials =
//              new AWSCredentials(s3AccessKey, s2SecretKey);
//      S3Service s3 = new RestS3Service(awsCredentials);
//      S3Bucket bucket = s3.getBucket("spittrImages");
//      S3Object imageObject =
//              new S3Object(image.getOriginalFilename());
        // Create S3 bucket and object
//      imageObject.setDataInputStream(
//              image.getInputStream());
//      // Set image data
//      imageObject.setContentLength(image.getSize());
//      imageObject.setContentType(image.getContentType());
//      AccessControlList acl = new AccessControlList();
//      acl.setOwner(bucket.getOwner());
//      acl.grantPermission(GroupGrantee.ALL_USERS,
        // Set permissions
//              Permission.PERMISSION_READ);
//      imageObject.setAcl(acl);
//      s3.putObject(bucket, imageObject);
//    } catch (Exception e) {
        // Save image
//      throw new ImageUploadException("Unable to save image", e);
//    }
//  }
  
}
