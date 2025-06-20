package ch.axa.punchclock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.axa.punchclock.models.category;
import ch.axa.punchclock.Repositories.CategoryRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController{

  @Autowired
  private CategoryRepository categoryRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public category create(@RequestBody @Valid category category) {
    return categoryRepository.save(category);
  }

  @GetMapping
  public Iterable<category> index() {
    return categoryRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<category> read(@PathVariable Long id) {
    return ResponseEntity.of(categoryRepository.findById(id));
  }

  @PutMapping("/{id}")
  public category update(@PathVariable Long id, @RequestBody @Valid category category) {
    category.setId(id);
    return categoryRepository.save(category);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<category> delete(@PathVariable Long id) {
    var category = categoryRepository.findById(id);
    if(category.isPresent()) {
      categoryRepository.delete(category.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}