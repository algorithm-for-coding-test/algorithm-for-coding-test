const fs = require('fs');

// settings
const outputFile = 'README.md';
const exceptFolderList = ['.git', '.idea', '.vscode', 'out'];
const students = ['김현창', '김희연', '이상학', '지인성'];
const checkMark = '✔';
const uncheckMark = '❌';
const weekSummary = {
    week1: '1주차 - DFS&BFS',
};
const platform = {
    BOJ: '백준',
    PRGS: '프로그래머스',
    LEET: '리트코드',
    SWEA: 'SWEA',
};

// data
const problemSet = {};

// preprocessing
const studentCount = students.length;
const studentIndexMapper = {};
const solveCounter = [];
for (let i = 0; i < studentCount; ++i) {
    studentIndexMapper[students[i]] = i;
    solveCounter.push(0);
}

function getCodeAuthor(codeFile) {
    for (const student of students) {
        if (codeFile.includes(student)) {
            return student;
        }
    }
    return null;
}

function readFiles() {
    fs.readdirSync('./', { withFileTypes: true }).forEach((file) => {
        if (
            !file.isDirectory() ||
            exceptFolderList.indexOf(file['name']) != -1
        ) {
            return;
        }
        const dirPath = './' + file.name;
        problemSet[file.name] = {};
        fs.readdirSync(dirPath, { withFileTypes: true }).forEach((problem) => {
            problemSet[file.name][problem.name] = [];
            for (let i = 0; i < studentCount; ++i) {
                problemSet[file.name][problem.name].push(false);
            }
            fs.readdirSync(dirPath + '/' + problem.name).forEach((codeFile) => {
                const authorIndex = studentIndexMapper[getCodeAuthor(codeFile)];
                ++solveCounter[authorIndex];
                problemSet[file.name][problem.name][authorIndex] = true;
            });
        });
    });
    console.log('solved! ' + solveCounter.join(', '));
}

function writeMarkDownFile() {
    // write md file
    if (!fs.existsSync(outputFile)) {
        fs.openSync(outputFile, 'w', 666);
    }
    fs.writeFileSync(outputFile, '## Algorithm \n');

    for (const week in problemSet) {
        if (weekSummary[week] === undefined) continue;
        let content = `<details>\n<summary>\n<b>${weekSummary[week]}</b>\n</summary>\n\n| 플랫폼 | 레벨 | 문제 | 제목 | `;
        for (const student of students) {
            content += student + ' | ';
        }
        content += '\n|';
        for (let i = 0; i < studentCount + 4; ++i) {
            content += ' :---: |';
        }
        content += '\n';
        const problems = problemSet[week];
        for (const problem in problems) {
            const [platformCode, number, level, name] = problem.split('_');
            content += `| ${platform[platformCode]} | ${level} | ${number} | ${name} |`;
            for (const solve of problemSet[week][problem]) {
                content += ' ' + (solve ? checkMark : uncheckMark) + ' |';
            }
            content += '\n';
        }
        content += '\n</details>';
        fs.appendFileSync(outputFile, content, 'utf-8');
    }
    console.log('saved successfully! ' + outputFile);
}

console.log('saving... ');
readFiles();
writeMarkDownFile();
