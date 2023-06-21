package com.tinqin.academy.piim.restexport;

import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsInput;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsResult;
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface PiimApiClient {
    //
//    // Category
//    @GetMapping("/api/categories")
//    GetAllCategoryResults getAllCategories();
//
//    @GetMapping("/api/categories/{id}")
//    GetByIdCategoryResult getCategoryById(@PathVariable long id);
//
//
//    @GetMapping(path = "/api/categories", params = "name")
//    GetByNameCategoryResult getCategoryByName(@RequestParam(name = "name") String name);
//
//    @PostMapping("/api/categories")
//    CreateCategoryResult createCategory(@RequestBody @Valid CreateCategoryInput input);
//
//    @PutMapping("/api/categories/{id}")
//    UpdateCategoryResult updateCategory(@PathVariable long id, @RequestBody @Valid UpdateCategoryInput input);
//
//    @DeleteMapping("/api/categories/{id}")
//    DeleteCategoryResult deleteCategory(@PathVariable long id);
//
//
//    // Game
//    @GetMapping("/api/games")
//    GetAllGamesResults getAllGames();
//
//    @GetMapping("/api/games/{id}")
//    GetByIdGameResult getGameById(@PathVariable long id);
//
    @RequestLine("POST /api/games/get-by-ids")
    GetAllGamesByIdsResult getAllGamesByIds(GetAllGamesByIdsInput getAllGamesByIdsInput);

    //
//
//    @GetMapping(path = "/api/games", params = "name")
//    GetByNameGameResult getGameByName(@RequestParam(name = "name") String name);
//
//    @PostMapping("/api/games")
//    CreateGameResult createGame(@RequestBody @Valid CreateGameInput game);
//
//    @PutMapping("/api/games/{id}")
//    UpdateGameResult updateGame(@PathVariable long id, @Valid @RequestBody UpdateGameInput updateGameInput);
//
//    @DeleteMapping("/api/games/{id}")
//    DeleteGameResult deleteGame(@PathVariable long id);
//
//
//    // Game patch
//    @GetMapping("/api/game-patches")
//    GetAllGamePatchesResults getAllGamePatches();
//
//    @GetMapping("/api/game-patches/{id}")
//    GetGamePatchByIdResult findGamePatchById(@PathVariable Long id);
//
//    @PostMapping("/api/game-patches")
//    CreateGamePatchResult createGamePatch(@Valid @RequestBody CreateGamePatchInput input);
//
//    @PutMapping("/api/game-patches/{id}")
//    UpdateGamePatchResult updateGamePatch(@PathVariable Long id,
//                                          @Valid @RequestBody UpdateGamePatchInput updateGamePatchInput);
//
//    @DeleteMapping("/api/game-patches/{id}")
//    DeleteGamePatchResult deleteGamePatch(@PathVariable Long id);
//
//
//    // Review
//    @GetMapping("/api/reviews/{id}")
//    GetByIdReviewResult getReviewById(@PathVariable @Valid long id);
//
    @RequestLine("GET /api/reviews?gameId={gameId}")
    GetReviewsByGameIdResult getReviewsByGameId(@Param Long gameId);

//    @GetMapping("/api/reviews")
//    GetAllReviewsResult getAllReviews();
//
//    @PostMapping("/api/reviews")
//    CreateReviewResult createReview(@RequestBody @Valid CreateReviewInput review);
//
//
//    @PutMapping("/api/reviews/{id}")
//    UpdateReviewResult updateReview(@PathVariable long id, @RequestBody @Valid UpdateReviewInput review);
//
//    @DeleteMapping("/api/reviews/{id}")
//    DeleteReviewResult deleteReview(@PathVariable long id);
//
//
//    // System Requirements
//    @RequestLine("GET /api/system-requirements")
////    @GetMapping("/api/system-requirements")
//    GetAllSystemRequirementsResults getAllSystemRequirements();
//
//    @GetMapping("/api/system-requirements/{id}")
//    GetSystemRequirementsByIdResult getRequirementsById(@PathVariable Long id);
//
//    @PostMapping("/api/system-requirements")
//    CreateSystemRequirementsResult createSystemRequirements(@RequestBody CreateSystemRequirementsInput systemRequirementsInput);
//
//    @PutMapping("/api/system-requirements/{id}")
//    UpdateSystemRequirementsResult updateSystemRequirements(@PathVariable Long id, @RequestBody @Valid UpdateSystemRequirementsInput systemRequirementsInput);
//
//    @DeleteMapping("/api/system-requirements/{id}")
//    DeleteSystemRequirementsResult deleteSystemRequirements(@PathVariable Long id);
//
//
//    // User
//    @PostMapping("/api/users")
//    CreateUserResult createUser(@RequestBody CreateUserInput user);
//
//    @PutMapping("/api/users/{id}")
//    UpdateUserResult updateUser(@PathVariable long id, @RequestBody UpdateUserInput updateUserInput);
//
//    @DeleteMapping("/api/users/{id}")
//    DeleteUserResult deleteUser(@PathVariable long id);
//
//    @GetMapping("/api/users/{id}")
//    GetUserByIdResult getUserById(@PathVariable long id);
//
//    @GetMapping("/api/users")
//    GetAllUsersResults getAllUsers();
}
