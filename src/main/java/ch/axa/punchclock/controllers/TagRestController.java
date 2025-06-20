package ch.axa.punchclock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ch.axa.punchclock.models.tag;
import ch.axa.punchclock.Repositories.tagRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tag")
public class TagRestController{

  @Autowired
  private tagRepository tagRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public tag create(@RequestBody @Valid tag tag) {
    return tagRepository.save(tag);
  }

  @GetMapping
  public Iterable<tag> index() {
    return tagRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<tag> read(@PathVariable Long id) {
    return ResponseEntity.of(tagRepository.findById(id));
  }

  @PutMapping("/{id}")
  public tag update(@PathVariable Long id, @RequestBody @Valid tag tag) {
    tag.setId(id);
    return tagRepository.save(tag);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<tag> delete(@PathVariable Long id) {
    var tag = tagRepository.findById(id);
    if(tag.isPresent()) {
      tagRepository.delete(tag.get());
      return new ResponseEntity<>(HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}