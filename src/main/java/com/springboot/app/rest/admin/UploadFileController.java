package com.springboot.app.rest.admin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.app.domain.Brand;
import com.springboot.app.repository.BrandRepository;

@RestController
@RequestMapping("")
public class UploadFileController {

	@Autowired
	private BrandRepository brandRepository;

	@RequestMapping(value = "/brands/showForm", method = RequestMethod.GET)
	public ModelAndView showForm() {
		ModelAndView v = new ModelAndView();
		v.setViewName("upload");
		return v;
	}

	@RequestMapping(value = "/brands/save", method = RequestMethod.POST)
	public String saveBrand(RedirectAttributes ra, @RequestParam("fileImage") MultipartFile multipartFile)
			throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		Brand b = new Brand();
		b.setLogo(fileName);
		Brand brandSave = brandRepository.save(b);
		String uploadDir = "/brand-logos/" + brandSave.getId();

		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {

			System.out.println(inputStream.toString());
			Path filePath = uploadPath.resolve(fileName);

			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {
			throw new IOException("Could not save upload file:" + fileName);
		}
		ra.addFlashAttribute("message", "The brand has been saved successfully");
		return "redirect:/brands";
	}

	@RequestMapping(value = "/brands/showForm2", method = RequestMethod.GET)
	public ModelAndView showForm2() {
		ModelAndView v = new ModelAndView();
		v.setViewName("uploadFile");
		return v;
	}

	@ResponseBody
	@RequestMapping(value = "/brands/file-upload", method = RequestMethod.POST)
	public ResponseEntity<String> fileUpload(MultipartFile file) {
		System.out.println("1");
		try {
			if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {
				System.out.println(file.getContentType());
				// clean file name
				String fileName = StringUtils.cleanPath(file.getOriginalFilename());

				// upload directory - change it to your own
				String UPLOAD_DIR = "/brand-logos";
				Path uploadPath = Paths.get(UPLOAD_DIR);

				if (!Files.exists(uploadPath)) {
					Files.createDirectories(uploadPath);
				}

				InputStream inputStream = file.getInputStream();
				Path filePath = uploadPath.resolve(fileName);

				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
				return new ResponseEntity<>("File uploaded!!", HttpStatus.OK);
			}
			return new ResponseEntity<>("Invalid file format!", HttpStatus.BAD_REQUEST);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("Invalid file format!!", HttpStatus.BAD_REQUEST);
		}

		
	}
}
