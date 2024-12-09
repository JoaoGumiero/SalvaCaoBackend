package salva_cao.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salva-cao/produtos")
public class ProductController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.createProduto(produto));
    };

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable long id) {
        return ResponseEntity.ok(produtoService.getProdutoById(id));
    };

    @GetMapping
    public ResponseEntity<Produto> getAllProduto() {
        return ResponseEntity.ok(produtoService.getAllAnimals());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateAnimal(@PathVariable Long id, @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.updateProduto(id, produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> deleteProdutoById(@PathVariable long id) {
        produtoService.deleteProdutoById(id);
        return ResponseEntity.noContent().build();
    };
}
