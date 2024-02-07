function copyText() {
    var textarea = document.getElementById("chatText");
    textarea.select();
    document.execCommand("copy");
    console.log(textarea);
    alert("Copied to clipboard!");
}