package com.jonathonterry.eruditecore.controller;

import com.jonathonterry.eruditecore.service.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BookController {
    private final StorageService storageService;

    @Autowired
    public BookController(StorageService storageService) {
        this.storageService = storageService;
    }

//    @GetMapping("/")
//    public String listUploadedFiles(Model model) throws IOException {
//
//        model.addAttribute("files", storageService.loadAll().map(
//          path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
//            "serveFile", path.getFileName().toString()).build().toUri().toString())
//          .collect(Collectors.toList()));
//
//        return "uploadForm";
//    }
//
//    @GetMapping("/files/{filename:.+}")
//    @ResponseBody
//    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
//
//        Resource file = storageService.loadAsResource(filename);
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//          "attachment; filename=\"" + file.getFilename() + "\"").body(file);
//    }
//
//    @PostMapping("/")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file,
//                                   RedirectAttributes redirectAttributes) {
//
//        storageService.store(file);
//        redirectAttributes.addFlashAttribute("message",
//          "You successfully uploaded " + file.getOriginalFilename() + "!");
//
//        return "redirect:/";
//    }
//
//    @ExceptionHandler(StorageFileNotFoundException.class)
//    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
//        return ResponseEntity.notFound().build();
//    }

    @PostMapping(path = "/book", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> uploadBook(
      @RequestParam("file") MultipartFile file,
      @RequestParam(name = "filename", required = false) String filename
    ) {
        storageService.store(file, filename);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookMetadata(@PathVariable("id") String bookId) {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/book/{id}/download")
    public ResponseEntity<?> getBookDownload(@PathVariable("id") String bookId) {
        return ResponseEntity.notFound().build();
    }
}