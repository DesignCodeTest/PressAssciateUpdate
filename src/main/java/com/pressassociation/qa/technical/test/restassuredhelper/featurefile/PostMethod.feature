Feature: Simulate requests to create, update or delete a video clip to the Daily Song queue

#Songs API now working
#Songs

#Case_01
Scenario: POST request to create a couple of video clips 
Given Accept the content in Json Format - PostToCreateAFewVideoClips
And Content Type as JSON - PostToCreateAFewVideoClips - PostToCreateAFewVideoClips
When I Post request with _id as "599cbda86ed7c10011a68b01",artist as "Lady Gaga",song as "Poker Face",publishDate as "2017-09-01T00:00:00.000Z",__v as "0", date_created as "2017-07-17T13:37:44.559Z" - PostToCreateAFewVideoClips
And I Post request with _id as "601cbda86ed7c10011a68b02",artist as "Ed Sheeran",song as "Shape of You ",publishDate as "2017-09-01T00:00:00.000Z",__v as "0", date_created as "2017-07-17T13:37:44.559Z" - PostToCreateAFewVideoClips
Then Status code "201" OK should be returned - PostToCreateAFewVideoClips
And Response should return the correct ID - PostToCreateAFewVideoClips

#("596cbda86ed7c10011a68b32", "Lady Gaga","Just Dance", "2017-09-01T00:00:00.000Z", "0", "2017-07-17T13:37:44.559Z"));

#Case_02
Scenario: GET request to return data about all existing video clips
Given the Accept content format is Json - GetsAllExistingVideoClips 
And  Content Type is JSON - GetsAllExistingVideoClips 
When I perform a Get request for all existing video clips - GetsAllExistingVideoClips 
Then Status code "200" - OK is expected - GetsAllExistingVideoClips 
And Response should return all clips with the correct credentials - GetsAllExistingVideoClips 
#
#
##Case_03
Scenario: GET request to return data about a single video
Given the Accept content format is Json - GetSingleVideoClip
And  with the Content Type as JSON - GetSingleVideoClip
When I perform Get request for video clips with _id as "598cbda86ed7c10011a68b42"  - GetSingleVideoClip
Then expected Status code "200" - OK - GetSingleVideoClip
And Response should return all clips with the correct credentials - GetSingleVideoClip
#
#
##Case_04
Scenario: POST request to create a video clip 
Given Accept the content in Json Format - PostToCreateVideoClip
And Content Type as JSON - PostToCreateVideoClip
When I Post request video clip with _id as "600cbda86ed7c10011a68b02",artist as "Beatles",song as "Life must go on",publishDate as "2017-09-01T00:00:00.000Z",__v as "0", date_created as "2017-07-17T13:37:44.559Z" - PostToCreateVideoClip
Then Status code "201" - Created should be returned - PostToCreateVideoClip
And Response should return the correct ID - PostToCreateVideoClip


#Case_05
Scenario: PATCH request to update data about a video clip
Given content in JSON - PatchToUpdate_A_VideoClip
And with the Content Type as JSON - PatchToUpdate_A_VideoClip
When I do a GET request with ID, "600cbda86ed7c10011a68b02"  - PatchToUpdate_A_VideoClip
Then expected Status code "200" - OK is returned - PatchToUpdate_A_VideoClip
When I perform a Patch request without any action against ID,"600cbda86ed7c10011a68b02" - This is a Patch Request"
Then expected HTTP status code response is "501" Not Implemented - PatchToUpdate_A_VideoClip
#And details should not get updated - PatchToUpdate_A_VideoClip
#
#
#
#Case_06
Scenario: DELETE request to remove a video clip
Given Accept content is JSON - removeVideoClip
And with the Content Type as JSON - removeVideoClip
When I do a GET request with ID, "598cbda86ed7c10011a68b36"  - removeVideoClip
Then expected Status code "200" - OK is returned - removeVideoClip
When I perform a DELETE request with ID "598cbda86ed7c10011a68b36" - removeVideoClip
Then expected response HTTP status code  is "204" - removeVideoClip
When I now repeat GET request with same ID, "598cbda86ed7c10011a68b36"  again - removeVideoClip
Then expected response HTTP status code  should be "200" OK - with data NOT found - removeVideoClip
#
#
#Playlist - Not fully working yet due to malformed Json body being passed to the POST method
#Playlist
#
#
##Case_07
#Scenario: POST request to create a couple of playlists 
#Given Accept the content in Json Format - PostToCreateAFewVideoClips
#And Content Type as JSON - PostToCreateAFewVideoClips - PostToCreateAFewVideoClips
#When I Post request with _id as "599cbda86ed7c10011a68b01",artist as "Lady Gaga",song as "Poker Face",publishDate as "2017-09-01T00:00:00.000Z",__v as "0", date_created as "2017-07-17T13:37:44.559Z" - PostToCreateAFewVideoClips
#And I Post request with _id as "601cbda86ed7c10011a68b02",artist as "Ed Sheeran",song as "Shape of You ",publishDate as "2017-09-01T00:00:00.000Z",__v as "0", date_created as "2017-07-17T13:37:44.559Z" - PostToCreateAFewVideoClips
#Then Status code "201" OK should be returned - PostToCreateAFewVideoClips
#And Response should return the correct ID - PostToCreateAFewVideoClips
#
#Case_08
#Scenario: GET request to return data about all existing playlists
#Given the Accept Content format is JSON 
#And  Content Type is JSON
#When I perform a Get request for all existing playlists
#Then Status code "200" - OK is expected in response
#And Response should return all playlists with correct credentials
#
#
##Case_09
#Scenario: GET request to return data about a single playlist
#Given the Accept content format is Json - GetSinglePlayList
#And  with the Content Type as JSON - GetSinglePlayList
#When I perform a Get request for all existing video clips - GetSinglePlayList
#Then expected Status code "200" - OK - GetSinglePlayList
#And Response should return all clips with the correct credentials - GetSinglePlayList
#
##
##Case_10
#Scenario: POST request to create a playlist
#Given the Accept content format is Json - PostToCreatePlayList
#And with the Content Type as JSON - PostToCreatePlayList
#When I perform a Post request with _id as somethingTBC - PostToCreatePlayList
#Then expected Http status code is "200" - OK - PostToCreatePlayList
#And Response should return all clips with the correct credentials - PostToCreatePlayList
#
#
##Case_11
#Scenario: PATCH request to add and remove songs from the playlist
#Given content in JSON - PatchToAddRemoveClipsFromPlaylist
#And with the Content Type as JSON - PatchToAddRemoveClipsFromPlaylist
#When I perform PATCHT request with ID - PatchToAddRemoveClipsFromPlaylist
#Then expected HTTP status code response is Http_SC_OK - PatchToAddRemoveClipsFromPlaylist
#And details should get updated - PatchToAddRemoveClipsFromPlaylist
#
#
##Case_12
#Scenario: DELETE request to remove a video clip from a playlist
#Given content in JSON - DeleteToRemoveClipFromPlaylist
#And with the Content Type as JSON - DeleteToRemoveClipFromPlaylist
#When I perform a DELETE request with ID of a clip in playlist - DeleteToRemoveClipFromPlaylist
#Then expected HTTP status code response is "204" - DeleteToRemoveClipFromPlaylist
#And I perform a GET for same ID - detail should now not be found - DeleteToRemoveClipFromPlaylist

