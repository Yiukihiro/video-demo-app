const form = document.querySelector('#video-form');
const formLikes = document.querySelector('#video-likes');
const videoDiv = document.querySelector('#video-player');
const videoScreen = document.querySelector('#video-screen');

const queryParams = Object.fromEntries(new URLSearchParams(window.location.search));

fetch('http://localhost/video')
    .then(result => result.json())
    .then(result => {

        const myVids = document.querySelector('#your-videos');
        if(result.length > 0){
            for(let vid of result){
                const li = document.createElement('LI');
                const link = document.createElement('A');
                link.innerText = vid.name + " " + vid.likes;
                link.href = window.location.origin + window.location.pathname + '?video=' + vid.name;
                li.appendChild(link);
                myVids.appendChild(li);
            }
        }else{
            myVids.innerHTML = 'No videos found';
        }

    });

if(queryParams.video){

    videoScreen.src = `http://localhost/video/data/${queryParams.video}`;
    videoDiv.style.display = 'block';
    document.querySelector('#now-playing')
        .innerText = 'Now playing ' + queryParams.video;

}

form.addEventListener('submit', ev => {
    ev.preventDefault();
    let data = new FormData(form);
    fetch('http://localhost/video', {
        method: 'POST',
        body: data
    }).then(result => result.text()).then(_ => {
        window.location.reload();
    });

});

formLikes.addEventListener('submit', ev => {
    ev.preventDefault();
    let data = new FormData(formLikes);
    fetch('http://localhost/video/likes/' + queryParams.video, {
        method: 'POST',
        body: data
    }).then(result => result.text()).then(_ => {
        window.location.reload();
    });

});
