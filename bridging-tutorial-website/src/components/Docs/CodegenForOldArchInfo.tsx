import React from 'react';

const headerText = 'You may notice, that JS specs contain codegen-related methods, classes, types, etc. to make things more future-proof.';
const subheaderText = 'That\'s because:';
const listItem1 = 'those elements are available since RN older versions (even from v0.65)';
const listItem2 = 'those elements are falling back to "old architecture" implementation (e.g. codegenNativeComponent)';
const listItem3 = 'it introduces type safety for exposed native parts on JS side';
const listItem4 = 'it\'s much easier to keep single specification on JS side - when old arch will be dropped, there\'ll be no need to change anything on JS side';
const summary = 'So to make it easier, let\'s use them, to get you more familiar with it 👍';

const CodegenForOldArchInfo: React.FC = () => {
  return <div>
    <p>{headerText}</p>
    <div>
      <p>{subheaderText}</p>
      <ul>
        <li>{listItem1}</li>
        <li>{listItem2}</li>
        <li>{listItem3}</li>
        <li>{listItem4}</li>
      </ul>
      <p>{summary}</p>
    </div>
  </div>;
};

export default CodegenForOldArchInfo;
