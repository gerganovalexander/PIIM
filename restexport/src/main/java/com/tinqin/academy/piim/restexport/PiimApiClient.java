package com.tinqin.academy.piim.restexport;

import com.tinqin.academy.piim.api.category.create.CreateCategoryInput;
import com.tinqin.academy.piim.api.category.create.CreateCategoryResult;
import com.tinqin.academy.piim.api.category.delete.DeleteCategoryResult;
import com.tinqin.academy.piim.api.category.getall.GetAllCategoryResults;
import com.tinqin.academy.piim.api.category.getbyid.GetByIdCategoryResult;
import com.tinqin.academy.piim.api.category.getbyname.GetByNameCategoryResult;
import com.tinqin.academy.piim.api.category.update.UpdateCategoryInput;
import com.tinqin.academy.piim.api.category.update.UpdateCategoryResult;
import com.tinqin.academy.piim.api.game.create.CreateGameInput;
import com.tinqin.academy.piim.api.game.create.CreateGameResult;
import com.tinqin.academy.piim.api.game.delete.DeleteGameResult;
import com.tinqin.academy.piim.api.game.getall.GetAllGamesResults;
import com.tinqin.academy.piim.api.game.getbyid.GetByIdGameResult;
import com.tinqin.academy.piim.api.game.getbyname.GetByNameGameResult;
import com.tinqin.academy.piim.api.game.update.UpdateGameInput;
import com.tinqin.academy.piim.api.game.update.UpdateGameResult;
import com.tinqin.academy.piim.api.gamepatch.create.CreateGamePatchInput;
import com.tinqin.academy.piim.api.gamepatch.create.CreateGamePatchResult;
import com.tinqin.academy.piim.api.gamepatch.delete.DeleteGamePatchResult;
import com.tinqin.academy.piim.api.gamepatch.getall.GetAllGamePatchesResults;
import com.tinqin.academy.piim.api.gamepatch.getbyid.GetGamePatchByIdResult;
import com.tinqin.academy.piim.api.gamepatch.update.UpdateGamePatchInput;
import com.tinqin.academy.piim.api.gamepatch.update.UpdateGamePatchResult;
import com.tinqin.academy.piim.api.review.create.CreateReviewInput;
import com.tinqin.academy.piim.api.review.create.CreateReviewResult;
import com.tinqin.academy.piim.api.review.delete.DeleteReviewResult;
import com.tinqin.academy.piim.api.review.getall.GetAllReviewsResult;
import com.tinqin.academy.piim.api.review.getbyid.GetByIdReviewResult;
import com.tinqin.academy.piim.api.review.update.UpdateReviewInput;
import com.tinqin.academy.piim.api.review.update.UpdateReviewResult;
import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.create.CreateSystemRequirementsResult;
import com.tinqin.academy.piim.api.systemrequirements.delete.DeleteSystemRequirementsResult;
import com.tinqin.academy.piim.api.systemrequirements.getall.GetAllSystemRequirementsResults;
import com.tinqin.academy.piim.api.systemrequirements.getbyid.GetSystemRequirementsByIdResult;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsInput;
import com.tinqin.academy.piim.api.systemrequirements.update.UpdateSystemRequirementsResult;
import com.tinqin.academy.piim.api.user.create.CreateUserInput;
import com.tinqin.academy.piim.api.user.create.CreateUserResult;
import com.tinqin.academy.piim.api.user.delete.DeleteUserResult;
import com.tinqin.academy.piim.api.user.getall.GetAllUsersResults;
import com.tinqin.academy.piim.api.user.getbyid.GetUserByIdResult;
import com.tinqin.academy.piim.api.user.update.UpdateUserInput;
import com.tinqin.academy.piim.api.user.update.UpdateUserResult;
import feign.Headers;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface PiimApiClient {

    // Category
    @GetMapping("/api/categories")
    GetAllCategoryResults getAllCategories();

    @GetMapping("/api/categories/{id}")
    GetByIdCategoryResult getCategoryById(@PathVariable long id);

    @GetMapping(path = "/api/categories", params = "name")
    GetByNameCategoryResult getCategoryByName(@RequestParam(name = "name") String name);

    @PostMapping("/api/categories")
    CreateCategoryResult createCategory(@RequestBody @Valid CreateCategoryInput input);

    @PutMapping("/api/categories/{id}")
    UpdateCategoryResult updateCategory(@PathVariable long id, @RequestBody @Valid UpdateCategoryInput input);

    @DeleteMapping("/api/categories/{id}")
    DeleteCategoryResult deleteCategory(@PathVariable long id);


    // Game
    @GetMapping("/api/games")
    GetAllGamesResults getAllGames();

    @GetMapping("/api/games/{id}")
    GetByIdGameResult getGameById(@PathVariable long id);

    @GetMapping(path = "/api/games", params = "name")
    GetByNameGameResult getGameByName(@RequestParam(name = "name") String name);

    @PostMapping("/api/games")
    CreateGameResult createGame(@RequestBody @Valid CreateGameInput game);

    @PutMapping("/api/games/{id}")
    UpdateGameResult updateGame(@PathVariable long id, @Valid @RequestBody UpdateGameInput updateGameInput);

    @DeleteMapping("/api/games/{id}")
    DeleteGameResult deleteGame(@PathVariable long id);


    // Game patch
    @GetMapping("/api/game-patches")
    GetAllGamePatchesResults getAllGamePatches();

    @GetMapping("/api/game-patches/{id}")
    GetGamePatchByIdResult findGamePatchById(@PathVariable Long id);

    @PostMapping("/api/game-patches")
    CreateGamePatchResult createGamePatch(@Valid @RequestBody CreateGamePatchInput input);

    @PutMapping("/api/game-patches/{id}")
    UpdateGamePatchResult updateGamePatch(@PathVariable Long id,
                                          @Valid @RequestBody UpdateGamePatchInput updateGamePatchInput);

    @DeleteMapping("/api/game-patches/{id}")
    DeleteGamePatchResult deleteGamePatch(@PathVariable Long id);


    // Review
    @GetMapping("/api/reviews/{id}")
    GetByIdReviewResult getReviewById(@PathVariable @Valid long id);

    @GetMapping("/api/reviews")
    GetAllReviewsResult getAllReviews();

    @PostMapping("/api/reviews")
    CreateReviewResult createReview(@RequestBody @Valid CreateReviewInput review);


    @PutMapping("/api/reviews/{id}")
    UpdateReviewResult updateReview(@PathVariable long id, @RequestBody @Valid UpdateReviewInput review);

    @DeleteMapping("/api/reviews/{id}")
    DeleteReviewResult deleteReview(@PathVariable long id);


    // System Requirements
    @GetMapping("/api/system-requirements")
    GetAllSystemRequirementsResults getAllSystemRequirements();

    @GetMapping("/api/system-requirements/{id}")
    GetSystemRequirementsByIdResult getRequirementsById(@PathVariable Long id);

    @PostMapping("/api/system-requirements")
    CreateSystemRequirementsResult createSystemRequirements(@RequestBody CreateSystemRequirementsInput systemRequirementsInput);

    @PutMapping("/api/system-requirements/{id}")
    UpdateSystemRequirementsResult updateSystemRequirements(@PathVariable Long id, @RequestBody @Valid UpdateSystemRequirementsInput systemRequirementsInput);

    @DeleteMapping("/api/system-requirements/{id}")
    DeleteSystemRequirementsResult deleteSystemRequirements(@PathVariable Long id);


    // User
    @PostMapping("/api/users")
    CreateUserResult createUser(@RequestBody CreateUserInput user);

    @PutMapping("/api/users/{id}")
    UpdateUserResult updateUser(@PathVariable long id, @RequestBody UpdateUserInput updateUserInput);

    @DeleteMapping("/api/users/{id}")
    DeleteUserResult deleteUser(@PathVariable long id);

    @GetMapping("/api/users/{id}")
    GetUserByIdResult getUserById(@PathVariable long id);

    @GetMapping("/api/users")
    GetAllUsersResults getAllUsers();
}
