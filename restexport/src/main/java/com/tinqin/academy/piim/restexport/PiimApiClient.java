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
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsInput;
import com.tinqin.academy.piim.api.game.getallbyids.GetAllGamesByIdsResult;
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
import com.tinqin.academy.piim.api.review.getreviewsbygameid.GetReviewsByGameIdResult;
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
import feign.Param;
import feign.RequestLine;

@Headers({"Accept: application/json", "Content-Type: application/json"})
public interface PiimApiClient {

    // Category
    @RequestLine("GET /api/categories")
    GetAllCategoryResults getAllCategories();

    @RequestLine("GET /api/categories/{id}")
    GetByIdCategoryResult getCategoryById(@Param long id);
    
    @RequestLine("GET /api/categories?name={name}")
    GetByNameCategoryResult getCategoryByName(@Param String name);

    @RequestLine("POST /api/categories")
    CreateCategoryResult createCategory(CreateCategoryInput input);

    @RequestLine("PUT /api/categories/{id}")
    UpdateCategoryResult updateCategory(@Param long id, UpdateCategoryInput input);

    @RequestLine("DELETE /api/categories/{id}")
    DeleteCategoryResult deleteCategory(@Param long id);


    // Game
    @RequestLine("GET /api/games")
    GetAllGamesResults getAllGames();

    @RequestLine("POST /api/games/get-by-ids")
    GetAllGamesByIdsResult getAllGamesByIds(GetAllGamesByIdsInput getAllGamesByIdsInput);

    @RequestLine("GET /api/games/{id}")
    GetByIdGameResult getGameById(@Param long id);

    @RequestLine("GET /api/games?name={name}")
    GetByNameGameResult getGameByName(@Param String name);

    @RequestLine("POST /api/games")
    CreateGameResult createGame(CreateGameInput game);

    @RequestLine("PUT /api/games/{id}")
    UpdateGameResult updateGame(@Param long id, UpdateGameInput updateGameInput);

    @RequestLine("DELETE /api/games/{id}")
    DeleteGameResult deleteGame(@Param long id);


    // Game patch
    @RequestLine("GET /api/game-patches")
    GetAllGamePatchesResults getAllGamePatches();

    @RequestLine("GET /api/game-patches/{id}")
    GetGamePatchByIdResult findGamePatchById(@Param Long id);

    @RequestLine("POST /api/game-patches")
    CreateGamePatchResult createGamePatch(CreateGamePatchInput input);

    @RequestLine("PUT /api/game-patches/{id}")
    UpdateGamePatchResult updateGamePatch(@Param Long id,
                                          UpdateGamePatchInput updateGamePatchInput);

    @RequestLine("DELETE /api/game-patches/{id}")
    DeleteGamePatchResult deleteGamePatch(@Param Long id);


    // Review
    @RequestLine("GET /api/reviews")
    GetAllReviewsResult getAllReviews();

    @RequestLine("GET /api/reviews?gameId={gameId}")
    GetReviewsByGameIdResult getReviewsByGameId(@Param Long gameId);

    @RequestLine("GET /api/reviews/{id}")
    GetByIdReviewResult getReviewById(@Param long id);

    @RequestLine("POST /api/reviews")
    CreateReviewResult createReview(CreateReviewInput review);

    @RequestLine("PUT /api/reviews/{id}")
    UpdateReviewResult updateReview(@Param long id, UpdateReviewInput review);

    @RequestLine("DELETE /api/reviews/{id}")
    DeleteReviewResult deleteReview(@Param long id);


    // System Requirements
    @RequestLine("GET /api/system-requirements")
    GetAllSystemRequirementsResults getAllSystemRequirements();

    @RequestLine("GET /api/system-requirements/{id}")
    GetSystemRequirementsByIdResult getRequirementsById(@Param Long id);

    @RequestLine("POST /api/system-requirements")
    CreateSystemRequirementsResult createSystemRequirements(CreateSystemRequirementsInput systemRequirementsInput);

    @RequestLine("PUT /api/system-requirements/{id}")
    UpdateSystemRequirementsResult updateSystemRequirements(@Param Long id,
                                                            UpdateSystemRequirementsInput systemRequirementsInput);

    @RequestLine("DELETE /api/system-requirements/{id}")
    DeleteSystemRequirementsResult deleteSystemRequirements(@Param Long id);


    // User
    @RequestLine("GET /api/users")
    GetAllUsersResults getAllUsers();

    @RequestLine("GET /api/users/{id}")
    GetUserByIdResult getUserById(@Param long id);

    @RequestLine("POST /api/users")
    CreateUserResult createUser(CreateUserInput user);

    @RequestLine("PUT /api/users/{id}")
    UpdateUserResult updateUser(@Param long id, UpdateUserInput updateUserInput);

    @RequestLine("DELETE /api/users/{id}")
    DeleteUserResult deleteUser(@Param long id);
}
