<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tube</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/styles.css">

</head>
<body>
    <header>
        <h1>Tube</h1>
    </header>
    <main>

        <div id="video-list">
            <header>
                <h3>Your videos</h3>
            </header>
            <ul id="your-videos">
            </ul>
        </div>
        <div id="video-player">
            <header>
                <h3 id="now-playing"></h3>
            </header>
            <video id="video-screen" width="720px" height="480px" controls></video>

            <form id="video-likes">
                <button type="submit">Like</button>
            </form>

        </div>




        <form id="video-form">
            <fieldset>
                <legend>Upload a video</legend>
                <label for="file">Video File</label>
                <input id="file" name="file" type="file" accept="application/mp4">
                <label for="name">Video Name</label>
                <input id="name" name="name" type="text">
                <button type="submit">Save</button>
            </fieldset>
        </form>



    </main>
    <script src="../js/main.js"></script>
</body>
</html>